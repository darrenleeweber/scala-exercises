# scala-exercises

Scala exercises

## Dependencies

- java 8
  - http://www.oracle.com/technetwork/java/javase/overview/java8-2100321.html
- sbt
  - https://www.scala-sbt.org/

## Usage

```bash
git clone git@github.com:darrenleeweber/scala-exercises.git
cd scala-exercises
sbt test
```

## Intervals

Run main examples, using `./data/intervals`
```bash
$ cat data/intervals 
2 6
9 12
8 9
18 21
4 7
10 11
```

The aim is to identify any intervals that were skipped in the
sequence of intervals.  Each interval is a tuple of values (a,b),
which can be assumed to obey the relation `a <= b`.

### Inclusive Intervals

The first example assumes the intervals are inclusive, i.e.
[a,b] such that [a,a] denotes the set {a}.  For example,
[1,4] => 1,2,3,4

```bash
$ sbt "runMain org.example.scala.IntervalSkips ./data/intervals"
skipped ranges:
Interval(12,17)
```

A proposed exercise solution was: 7-8, 12-18.  This is impossible if
all the intervals are assumed to be closed, i.e. [a,b].  The above
solution is correct for an inclusive interval. Note that a sequence
of intervals: [2,6], [4,7], [8,9] is a continuous section of the
sequence of real integers.

### Intervals with Open Ended Range

The second example assumes the intervals are open ended, i.e.
[a,b) such that [a,a) denotes the empty set {}.  For example,
[1,4) => 1,2,3

```bash
$ sbt "runMain org.example.scala.RangeSkips ./data/intervals"
skipped ranges:
Range 7 until 8
Range 11 until 18
```

A proposed exercise solution was: 7-8, 12-18.  This is impossible if
all the intervals are assumed to be open ended.  The above
solution is correct for an open ended interval. Note that a sequence
of intervals: [2,6), [4,7), [7,9) is a continuous section of the
sequence of real integers.  However, the sequence of intervals:
[2,6), [4,7), [8,9) is not, it skips [7,8).

#### Implementation Notes

A faster alternative is possible, using binary trees that are more efficient at
building and querying the intervals, see benchmarks below and algorithm tips at:
- https://en.wikipedia.org/wiki/Interval_tree

The solutions implemented in `Intervals` and `Ranges` accumulate all the
intervals into a `ListBuffer` (the append operations are `O(1)` [1]).  The
`Interval` class implements an inclusive interval, i.e. [a,b]; the scala library
`Range` class implements an open ended interval, i.e. [a,b).  The entire
sequence of intervals are sorted by increasing values of the interval start (a
default scala sort algorithm is used, which calls java Array.sort [2]).  It then
identifies skipped intervals by collecting every second pair of the sorted
sequence if there is any gap between them, the new sequence is the gaps.  The
details of what constitutes a skipped interval depend on the assumption about
the interval (closed or open ended); see the `Intervals` and `Ranges` classes
for those details.

Another brute-force solution could use the min and max of all the intervals to
construct a set of all the values in that range (or a sparse array).  It could
also compose a set of all the values in the intervals (also a sparse array).
The difference in those sets is the intervals that are skipped.  Any
discontinuity in the sorted sequence of that set marks the boundary of a skipped
interval.  This approach is a robust approach, but it likely requires more
memory and more time to calculate set differences and to iterate through a final
sorted sequence.  Although this in an intuitive solution, the solution above was
adopted as a more efficient option.

[1] http://docs.scala-lang.org/overviews/collections/performance-characteristics.html

[2] A call stack for Intervals.sorted:

```
java.util.Arrays.sort(Arrays.java:1438)
scala.collection.SeqLike.sorted(SeqLike.scala:652)
scala.collection.SeqLike.sorted$(SeqLike.scala:640)
scala.collection.AbstractSeq.sorted(Seq.scala:41)
scala.collection.SeqLike.sortWith(SeqLike.scala:605)
scala.collection.SeqLike.sortWith$(SeqLike.scala:605)
scala.collection.AbstractSeq.sortWith(Seq.scala:41)
org.example.scala.Intervals.sorted(Intervals.scala:18)
```

#### Benchmarks

To run benchmarks in sbt:

```
jmh:clean
jmh:run -i 20 -wi 10 -f1 -t1
```

Example benchmarks on `Intervals` and `Ranges` with random arrays of integer
inputs.  The `n` is the number of intervals (not  the entire range of real
integers covered by all the intervals).  The initial append operation is
constant time for each of the n intervals, so that's `O(n)` append ops; the sort
is whatever java `Array.sort` does (in java-8), and the final pair-wise skip
comparisons are a little less than `O(n)`.  All together, it's a little under an
`O(n^2)` with minimal use of memory:

```
[info] Benchmark                      Mode  Cnt   Score   Error   Units
[info] BenchIntervalTree.skipped100  thrpt   20  18.639 ± 0.395  ops/ms
[info] BenchIntervalTree.skipped300  thrpt   20   7.230 ± 0.253  ops/ms
[info] BenchIntervalTree.skipped500  thrpt   20   4.564 ± 0.173  ops/ms
[info] BenchIntervalTree.skipped700  thrpt   20   3.339 ± 0.094  ops/ms
[info] BenchIntervalTree.skipped900  thrpt   20   2.813 ± 0.088  ops/ms

[info] BenchIntervals.skipped100     thrpt   20  17.343 ± 0.668  ops/ms
[info] BenchIntervals.skipped300     thrpt   20   5.672 ± 0.895  ops/ms
[info] BenchIntervals.skipped500     thrpt   20   3.566 ± 0.265  ops/ms
[info] BenchIntervals.skipped700     thrpt   20   2.315 ± 0.292  ops/ms
[info] BenchIntervals.skipped900     thrpt   20   1.678 ± 0.090  ops/ms

[info] BenchRanges.skipped100        thrpt   20  15.690 ± 0.977  ops/ms
[info] BenchRanges.skipped300        thrpt   20   6.238 ± 0.216  ops/ms
[info] BenchRanges.skipped500        thrpt   20   3.123 ± 0.114  ops/ms
[info] BenchRanges.skipped700        thrpt   20   2.398 ± 0.070  ops/ms
[info] BenchRanges.skipped900        thrpt   20   1.994 ± 0.046  ops/ms
```

Benchmark references:
- http://tutorials.jenkov.com/java-performance/jmh.html
- https://github.com/ktoso/sbt-jmh

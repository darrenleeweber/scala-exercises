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

The solutions implemented in `Intervals` and `Ranges` accumulate
intervals into a `ListBuffer` of a new class for `Interval`; the
append operations are `O(1)` for a `ListBuffer` [1].  The `Interval`
class implements an inclusive interval, i.e. [a,b]; the scala library
`Range` class implements an open ended interval, i.e. [a,b).  The sequence
of intervals are sorted by increasing values of the interval start (a
default scala sort algorithm is used, which calls java Array.sort, [2]).
It then identifies skipped intervals by mapping every second pair of that sorted
sequence into a new sequence of `Interval` or `Range`.  The details of what
constitutes a skipped interval depend on the assumption about
the interval (closed or open ended); see the `Intervals` and `Ranges`
classes for those details.

An alternative solution could use the min and max of all the intervals to
construct a set of all the values in that range.  It could also compose
a set of all the values in the intervals.  The difference in those sets
is the intervals that are skipped.  Any discontinuity in the sorted sequence
of that set marks the boundary of a skipped interval.  This approach is a
robust approach, but it likely requires more memory and more time to calculate
set differences and to iterate through a final sorted sequence.  Although this
in an intuitive solution, the solution above was adopted as a more efficient
option.

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

The benchmarks are kept in a `benchmarks` branch, to separate the code from
the main package.  The branch needs to be kept up to date with master, as
required.

To run benchmarks:

```
git checkout benchmarks
sbt
> test
> jmh:clean
> jmh:run -i 20 -wi 10 -f1 -t1
```

Example bechmarks on `Intervals` with random arrays of integer inputs, indicating
the `Intervals.sorted` and `Intervals.skipped` methods run in `O(n)` time:
```
[info] # Run complete. Total time: 00:03:04
[info] Benchmark                   Mode  Cnt    Score   Error   Units

[info] BenchIntervals.sorted10     thrpt   20  819.741 ± 30.190  ops/ms
[info] BenchIntervals.sorted100    thrpt   20   62.362 ±  2.345  ops/ms
[info] BenchIntervals.sorted1000   thrpt   20    5.057 ±  0.130  ops/ms

[info] BenchIntervals.skipped10    thrpt   20  591.115 ± 26.271  ops/ms
[info] BenchIntervals.skipped100   thrpt   20   58.320 ±  1.734  ops/ms
[info] BenchIntervals.skipped1000  thrpt   20    4.699 ±  0.201  ops/ms

[success] Total time: 197 s, completed Dec 28, 2017 8:17:14 PM
```

Benchmark references:
- http://tutorials.jenkov.com/java-performance/jmh.html
- https://github.com/ktoso/sbt-jmh

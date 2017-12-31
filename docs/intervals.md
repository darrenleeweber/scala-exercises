# Intervals

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

## Inclusive Intervals

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
of intervals: [2,6], [4,7], [8,9] is a continuous sequence of real
integers (with some overlap).

## Intervals with Open Ended Range

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

## Implementation Notes

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
The difference in those sets is the intervals that are skipped.  Any discontinuity
in the sorted sequence of that set marks the boundary of a skipped interval.
This approach requires more memory and more time to calculate set differences
and to iterate through a final sorted sequence.  The use of a set data structure
resolves any overlaps in the interval sequence.

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

### Benchmarks

```
sbt "testOnly org.example.bench.BenchmarkIntervals"
```

Example benchmarks use random arrays of integer inputs.  The `n` is the number
of intervals (not  the entire range of real integers covered by all the intervals).
The initial append operation is constant time for each of the `n` intervals in the
`Intervals` and `Ranges`, so that's `O(n)` append ops.  The `IntervalTree` is a
red-black binary tree that should be `O(log-n)` time for appends, which also sort
the intervals.  The `IntervalTree` should have a more efficient sort process than
the `Intervals` and `Ranges`. The `Intervals` and `Ranges` need to be sorted, which
is a java `Array.sort` (java-8, scala 2.12) ; the `IntervalTree` is sorted while it is
built, so the sort operation is just mapping the data into an `Interval` to satisfy
the public API of the class.  The final pair-wise skip comparisons are a little
less than `O(n)`. 


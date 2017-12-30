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

## Exercises

- [Intervals](docs/intervals.md)


## Benchmarks

To run benchmarks in sbt:

```
jmh:clean
jmh:run -i 20 -wi 10 -f1 -t1
```

Benchmark references:
- http://tutorials.jenkov.com/java-performance/jmh.html
- https://github.com/ktoso/sbt-jmh

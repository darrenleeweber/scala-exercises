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

- [Arrays](docs/arrays.md)
- [Intervals](docs/intervals.md)

## Specs

To run specs in sbt:

```
sbt "testOnly org.example.scala.*"
```

## Benchmarks

To run benchmarks in sbt:

```
sbt "testOnly org.example.bench.*"
```

To view a benchmark report, open the HTML file from
- `target/benchmarks/report/index.html`

A version of the benchmarks is on github.io at:
- https://darrenleeweber.github.io/scala-exercises/

Benchmark references:
- http://scalameter.github.io/

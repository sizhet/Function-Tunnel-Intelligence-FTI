# CPG–CPA MVP v0.1

**CCC-Preserved Generation (CPG)** and **Core-CCC-Preserved Analysis (CPA)** form a dual runtime loop:

```text
Input Graph
  -> CPA: recover Core CCC + Policy CCC
  -> CPG: generate preservation-aware derivative candidates
  -> CPA again: recover CCC from derivative
  -> Validate: compare preservation and decide ACCEPT / REWRITE / REJECT
```

This MVP is intentionally small. It does not claim autonomous intelligence. It demonstrates the control-plane movement needed for structural generation.

## Run

```bash
mvn test
mvn -q exec:java -Dexec.mainClass=com.dbm.cpg.demo.CpgCpaWorkflowDemoMain
```

If `exec-maven-plugin` is not configured, run from an IDE or compile with Maven and invoke the main class.

## Demo

The default demo derives a `PlannerGraph` into several candidate variants, including a `DistributedPlannerGraph`, and validates whether `PLAN -> VALIDATE -> EXECUTE -> TRACE` and related policy CCCs are preserved.

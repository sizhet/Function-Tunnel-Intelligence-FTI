# MVP Demo Pack Recommendations

## MVP-001 — Elastic Curve Corridor Matching Demo

### Goal

Demonstrate:

- multiple noisy trajectories,
- elastic alignment,
- corridor membership,
- and tunnel scoring.

### Suggested Structure

    fti-demo-elastic-ir/
    ├── ElasticCurve.java
    ├── TunnelEstimator.java
    ├── CurveSimilarityEngine.java
    ├── TunnelVisualizationPrinter.java
    ├── ElasticIrDemoMain.java
    └── README.md

### Key Output

    Trajectory A:
    INSIDE tunnel
    
    Trajectory B:
    INSIDE tunnel despite drift
    
    Trajectory C:
    OUTSIDE tunnel
    
### See: 
[../src/main/java/com/dbm/fti/elasticir/MVP-001—Elastic-Curve-Corridor-Matching-Demo.md](../src/main/java/com/dbm/fti/elasticir/MVP-001—Elastic-Curve-Corridor-Matching-Demo.md)

---

## MVP-002 — Drone Function-Tunnel Navigation Demo
### Goal

Compare:

- exact linear navigation\
vs.
- function-tunnel navigation.

### Simulated Factors
- drift
- wind
- IMU noise
- waypoint mismatch

### Key Visualization
    Linear Guidance:
    FAILED
    
    Function-Tunnel:
    RECOVERED

### See: 
[../src/main/java/com/dbm/fti/drone/MVP-002—Drone-Function-Tunnel-Navigation-Demo.md](../src/main/java/com/dbm/fti/drone/MVP-002—Drone-Function-Tunnel-Navigation-Demo.md)

---

## MVP-003 — Swarm Tunnel Cohesion Demo
### Goal

Demonstrate:

- decentralized agents,
- non-identical trajectories,
- structural corridor cohesion.

### Core Idea

Agents remain:

- behaviorally aligned,\
without:
- exact synchronization.

### See: 
[../src/main/java/com/dbm/fti/swarm/MVP-003—Swarm-Tunnel-Cohesion-Demo.md](../src/main/java/com/dbm/fti/swarm/MVP-003—Swarm-Tunnel-Cohesion-Demo.md)

---

## MVP-004 — LLM Runtime Tunnel Stabilization Demo
### Goal

Demonstrate:

- reasoning drift,
- hallucination deviation,
- runtime correction,
- tunnel stabilization.

### See: 
[../src/main/java/com/dbm/fti/runtime/MVP-004—LLM-Runtime-Tunnel-Stabilization-Demo.md](../src/main/java/com/dbm/fti/runtime/MVP-004—LLM-Runtime-Tunnel-Stabilization-Demo.md)

---

### Significance

Bridges:

- FTI\
with:
- future AI runtime governance.

## Recommended Java Runtime Skeleton

    src/main/java/com/dbm/fti/
        corridor/
        elasticir/
        tunnel/
        policy/
        runtime/
        swarm/
        drone/

## Suggested First Canonical Demo Names
    ElasticIrCorridorDemoMain
    DroneTunnelNavigationDemoMain
    SwarmTunnelCohesionDemoMain
    RuntimeTunnelStabilizationDemoMain

## Suggested Smoke Tests
    ElasticIrCorridorSmokeTest
    TunnelRecoverySmokeTest
    SwarmCohesionSmokeTest
    RuntimeTunnelGovernanceTest
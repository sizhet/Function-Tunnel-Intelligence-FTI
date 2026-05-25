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

## MVP-004 — LLM Runtime Tunnel Stabilization Demo
### Goal

Demonstrate:

- reasoning drift,
- hallucination deviation,
- runtime correction,
- tunnel stabilization.

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
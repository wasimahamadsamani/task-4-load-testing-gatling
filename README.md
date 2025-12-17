# Load Testing with Apache Gatling

CODTECH Internship Task 4: Load Testing - Performance and stress testing of web applications using Apache Gatling

## 🎬 Live Demo

**[View Interactive Demo](https://htmlpreview.github.io/?https://github.com/wasimahamadsamani/task-4-load-testing-gatling/blob/main/LOAD-TEST-DEMO.html)**

## Project Overview

A comprehensive load testing framework using Apache Gatling for performance and stress testing web applications. This project demonstrates industry-standard load testing practices with multiple test scenarios ranging from basic load tests to extreme stress tests.

## Objectives

- Master Apache Gatling framework setup and configuration
- Create realistic load test scenarios with different user volumes
- Measure and analyze application performance under load
- Identify bottlenecks and performance limitations
- Generate detailed performance reports
- Understand metrics like response times, throughput, and error rates

## Project Structure

```
load-testing/
├── pom.xml                          # Maven dependencies for Gatling
├── src/
│   └── test/
│       └── scala/
│           ├── BasicLoadTest.scala  # 10 concurrent users
│           ├── AdvancedLoadTest.scala # 50-200 users ramp up
│           └── StressTest.scala     # 400+ users extreme load
├── README.md                        # Project documentation
├── SETUP-GUIDE.md                   # Installation and setup instructions
└── PERFORMANCE-REPORT.md            # Sample performance analysis
```

## Gatling Concepts

### 1. Simulation
A simulation defines the entire load testing scenario including:
- User behavior
- Load patterns
- Request sequences
- Assertions

### 2. Scenarios
Scenarios represent real-world user journeys:
```scala
val scn = scenario("Basic Load Test")
  .exec(http("Home Page").get("/"))
  .pause(5)
  .exec(http("Login").post("/login")
    .formParam("username", "user")
    .formParam("password", "pass"))
```

### 3. User Ramp-up
Gradually increase users to simulate realistic load:
```scala
setUp(
  scn.inject(
    rampUsers(100) during (10 seconds)
  )
).protocols(httpConf)
```

### 4. Assertions
Validate performance requirements:
```scala
.assertions(
  global.responseTime.max.lt(2000),
  global.successfulRequests.percent.gt(95)
)
```

## Test Scenarios Implemented

### Scenario 1: Basic Load Test
- **Users:** 10 concurrent
- **Duration:** 5 minutes
- **Ramp-up:** 1 minute
- **Objective:** Baseline performance verification
- **Expected Response Time:** < 500ms
- **Success Rate:** > 99%

### Scenario 2: Advanced Load Test
- **Users:** 50-200 (ramped up)
- **Duration:** 10 minutes
- **Ramp-up:** 2 minutes
- **Objective:** Identify performance degradation
- **Expected Response Time:** < 1000ms
- **Success Rate:** > 95%

### Scenario 3: Stress Test
- **Users:** 400+ extreme
- **Duration:** 15 minutes
- **Ramp-up:** 3 minutes
- **Objective:** Find breaking point
- **Measure:** Failures, timeouts, resource exhaustion

## Key Performance Metrics

### Response Time
- **Mean:** Average response time
- **Min:** Fastest response
- **Max:** Slowest response
- **Percentiles:** 50th, 90th, 95th, 99th

### Throughput
- **RPS:** Requests per second
- **Success Rate:** % successful requests
- **Error Rate:** % failed requests

### Resource Usage
- **CPU Utilization:** Server CPU %
- **Memory Usage:** RAM consumption
- **Connection Pool:** Active connections

## Setup & Installation

### Prerequisites
- Java 11 or higher
- Maven 3.6+
- Git

### Step 1: Clone Repository
```bash
git clone https://github.com/wasimahamadsamani/task-4-load-testing-gatling.git
cd task-4-load-testing-gatling
```

### Step 2: Install Dependencies
```bash
mvn clean install
```

### Step 3: Run Load Test
```bash
mvn gatling:test -Dgatling.simulationClass=BasicLoadTest
```

## Running Different Test Scenarios

### Basic Load Test (10 users)
```bash
mvn gatling:test -Dgatling.simulationClass=BasicLoadTest
```

### Advanced Load Test (50-200 users)
```bash
mvn gatling:test -Dgatling.simulationClass=AdvancedLoadTest
```

### Stress Test (400+ users)
```bash
mvn gatling:test -Dgatling.simulationClass=StressTest
```

### Run All Simulations
```bash
mvn gatling:test
```

## Performance Report Generation

Gatling automatically generates HTML reports:
```
target/gatling/[simulation-name]-[timestamp]/index.html
```

Reports include:
- Response time distribution
- Throughput graphs
- Success/failure rates
- Detailed request statistics
- Percentile charts

## Best Practices for Load Testing

1. **Baseline Testing**
   - Establish baseline metrics
   - Compare against previous results

2. **Realistic User Behavior**
   - Simulate actual user journeys
   - Include think time between requests
   - Vary request patterns

3. **Gradual Ramp-up**
   - Don't flood with users instantly
   - Allow system to adapt
   - Monitor resource utilization

4. **Comprehensive Assertions**
   - Validate response times
   - Check success rates
   - Monitor specific transactions

5. **Data-Driven Tests**
   - Use different test data
   - Simulate various scenarios
   - Test edge cases

6. **Persistent Results**
   - Archive test reports
   - Track performance trends
   - Compare across versions

7. **Monitoring During Tests**
   - Monitor server metrics
   - Track resource usage
   - Identify bottlenecks

## Performance Analysis

### Response Time Analysis
- Identify slow endpoints
- Track p95, p99 latencies
- Detect performance degradation

### Throughput Analysis
- Measure requests per second
- Monitor error rates
- Identify breaking points

### Resource Analysis
- CPU and memory usage
- Connection pool saturation
- Database query performance

## Troubleshooting

**OutOfMemory Exception:**
- Increase heap size: `-Xmx2G`
- Reduce number of users

**Connection Refused:**
- Verify target server is running
- Check firewall rules
- Confirm network connectivity

**High Error Rates:**
- Check target application logs
- Verify test data
- Reduce load graduallyÂ 

**Slow Response Times:**
- Check server resources
- Review application code
- Analyze database queries

## Performance Thresholds

- **Excellent:** Response time < 200ms, Success rate > 99%
- **Good:** Response time < 500ms, Success rate > 98%
- **Acceptable:** Response time < 1000ms, Success rate > 95%
- **Poor:** Response time > 1000ms, Success rate < 95%

## Tools & Technologies

- **Apache Gatling** - Load testing framework
- **Scala** - Test scenario language
- **Maven** - Build automation
- **JVM** - Execution platform

## Status

✅ Gatling Framework Configured
✅ Load Test Scenarios Implemented
✅ Performance Metrics Analyzed
✅ Reports Generated

## License

MIT License

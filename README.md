# Load Testing with Apache Gatling

Task 4: CODTECH Internship

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
├── pom.xml                    # Maven dependencies for Gatling
├── src/
│   └── test/
│       └── scala/
│           ├── BasicLoadTest.scala       # 10 concurrent users
│           ├── AdvancedLoadTest.scala    # 50-200 users ramped up
│           └── StressTest.scala          # 400+ users extreme load
├── README.md                  # Project documentation
├── SETUP-GUIDE.md             # Installation and setup instructions
├── TEST-SCENARIOS.md          # Detailed test scenario descriptions
├── PERFORMANCE-METRICS.md     # Metrics explanation and interpretation
└── REPORT-ANALYSIS.md         # How to analyze Gatling reports
```

## Test Scenarios

### 1. Basic Load Test (BasicLoadTest.scala)
- **Users**: 10 concurrent users
- **Duration**: 5 minutes
- **Target**: http://localhost:8080/api
- **Purpose**: Baseline performance measurement

### 2. Advanced Load Test (AdvancedLoadTest.scala)
- **Users**: 50 to 200 (ramped over 5 minutes)
- **Duration**: 15 minutes
- **Scenarios**: Mixed realistic user journeys
- **Purpose**: Realistic production-like load

### 3. Stress Test (StressTest.scala)
- **Users**: 400+ concurrent users
- **Duration**: 10 minutes
- **Ramp-up**: Aggressive ramp-up
- **Purpose**: Find breaking point and max capacity

## Prerequisites

- Java 11 or higher
- Maven 3.6+
- Git
- A running web application to test

## Quick Start

### Installation

```bash
# Clone the repository
git clone https://github.com/yourusername/task-4-load-testing-gatling.git
cd task-4-load-testing-gatling

# Install dependencies
mvn clean install

# Run basic load test
mvn gatling:test -Dgatling.simulationClass=BasicLoadTest
```

### Running Tests

```bash
# Run specific test
mvn gatling:test -Dgatling.simulationClass=BasicLoadTest

# Run all tests
mvn gatling:test

# Run with custom parameters
mvn gatling:test -Dgatling.simulationClass=AdvancedLoadTest -Dusers=100
```

## Performance Metrics

### Key Metrics Explained

| Metric | Definition | Target |
|--------|-----------|--------|
| **Response Time** | Time taken for server to respond | < 1 second |
| **Mean** | Average response time | < 500 ms |
| **Min/Max** | Fastest/Slowest response | - |
| **95th Percentile** | 95% of requests faster than this | < 1 second |
| **Throughput** | Requests per second | Application dependent |
| **Error Rate** | % of failed requests | < 1% |

### Analyzing Results

1. Open `target/gatling/` directory
2. Find the latest test run folder
3. Open `index.html` in a browser
4. Analyze charts and statistics

## Common Issues

### Connection Refused
- Ensure your test application is running
- Check the correct URL in test class
- Verify firewall settings

### Out of Memory
- Increase JVM heap: `-Xmx2G` in Maven settings
- Reduce number of concurrent users
- Run tests on more powerful machine

### High Error Rates
- Application might not handle load
- Check application logs for errors
- Verify database connections
- Review connection pool settings

## Report Analysis

After each test run:

1. **Response Times**: Check if within SLA
2. **Throughput**: Verify server capacity
3. **Error Rate**: Investigate any failures
4. **Database**: Monitor query performance
5. **Memory**: Check for leaks

## Next Steps

- Tune application based on results
- Optimize database queries
- Add caching layers
- Scale infrastructure
- Re-run tests and compare

## Resources

- [Gatling Official Documentation](https://gatling.io/)
- [Gatling Maven Plugin](https://gatling.io/docs/gatling/tutorials/getting-started/)
- [Performance Testing Best Practices](https://gatling.io/docs/gatling/reference/current/)

## License

This project is part of CODTECH internship program.

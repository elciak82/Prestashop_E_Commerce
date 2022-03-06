# Prestashop_E_Commerce
start tests: mvn clean test
generate report: allure serve allure-results
clean old data: allure generate --clean --output allure-results

restart jenkins: http://localhost:8080/safeRestart - Allows all running jobs to complete. New jobs will remain in the queue to run after the restart is complete.
restart jenkins: http://localhost:8080/restart - Forces a restart without waiting for builds to complete.



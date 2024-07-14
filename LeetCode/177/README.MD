# Nth Highest Salary

```sql
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
set N = N-1;
RETURN (
    SELECT
        DISTINCT Salary
    FROM
        Employee
    ORDER BY
        Salary DESC
    limit 1
    offset N
);
END
```

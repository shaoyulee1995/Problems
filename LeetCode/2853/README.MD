# Highest Salaries Difference

```sql
with max_salary as (
    select
        department,
        max(salary) as 'salary'
    from
        Salaries
    group by
        1)

select
    abs(m.salary - e.salary) as 'salary_difference'
from
    max_salary m join max_salary e
where
    m.department = "Marketing" and
    e.department = "Engineering"
```

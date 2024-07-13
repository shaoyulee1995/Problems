# Managers with at Least 5 Direct Reports

```sql
with managers as(
    select
        managerId
    from
        Employee
    group by
        managerId
    having 
        count(managerId) >= 5
)

select
    name
from
    Employee e join managers m
    on e.id = m.managerId
```
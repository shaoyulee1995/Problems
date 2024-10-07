# Team Size

```sql
with Team as (
    select
        team_id, 
        count(*) as 'count'
    from 
        Employee
    group by 
        1)
select
    e.employee_id, 
    t.count as 'team_size'
from Employee e left join Team t
    using(team_id)
```
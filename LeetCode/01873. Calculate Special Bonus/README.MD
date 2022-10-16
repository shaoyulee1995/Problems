```
select
    employee_id,
    case
        when employee_id%2!=0 and name NOT LIKE 'M%'
        then salary
        else 0
    end as bonus
from Employees
order by employee_id
```
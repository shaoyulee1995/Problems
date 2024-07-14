# Loan Types

```sql
select
    user_id
from
    Loans
group by
    1
having
    sum(
    case
    when loan_type='Mortgage' then 1
         else 0
    end) >= 1 and
    sum(
    case
        when loan_type='Refinance' then 1
        else 0
    end) >= 1
order by
    1
```

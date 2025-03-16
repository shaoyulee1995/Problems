# Second Day Verificationq

```sql
select
    distinct e.user_id
from
    emails e join texts t 
    using(email_id)
where
    t.signup_action = 'Verified' and
    date_add(date(e.signup_date), interval 1 day) = date(t.action_date)
order by
    1 asc
```
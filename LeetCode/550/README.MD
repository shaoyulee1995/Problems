# Game Play Analysis IV

```sql
with first_login as (
    select
        player_id,
        min(event_date) as 'event_date'
    from
        Activity
    group by
        1)

select
    round(
        count(a.event_date)/count(fl.player_id)
    , 2) as 'fraction'
from
    Activity a right join first_login fl
    on a.player_id = fl.player_id and
    datediff(a.event_date, fl.event_date) = 1
```

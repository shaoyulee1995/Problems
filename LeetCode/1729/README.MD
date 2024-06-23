# Find Followers Count

```sql
select
    user_id,
    count(follower_id) as 'followers_count'
from
    Followers
group by
    1
order by
    1
```

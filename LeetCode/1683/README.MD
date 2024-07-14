# Invalid Tweets

```sql
select
    tweet_id
from
    Tweets
where
    length(content) > 15
```

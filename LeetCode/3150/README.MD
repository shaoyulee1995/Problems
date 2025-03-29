# Invalid Tweets II

```sql
select
    tweet_id
from 
    Tweets
where
    char_length(content) > 140 or 
    length(content) - length(replace(content, '@', '')) > 3 or
    length(content) - length(replace(content, '#', '')) > 3 
order by
    1
```
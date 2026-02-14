DELETE t1.*
FROM blacklist t1, blacklist t2 
WHERE t1.bewohner1 = t2.bewohner2 AND t2.bewohner2 = t1.bewohner1 AND t1.bewohner1<t1.bewohner2;


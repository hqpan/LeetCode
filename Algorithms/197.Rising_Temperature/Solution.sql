SELECT 
    Weather.Id
FROM
    Weather
        JOIN
    Weather t1 ON DATEDIFF(Weather.RecordDate, t1.RecordDate) = 1
        AND Weather.Temperature > t1.Temperature;

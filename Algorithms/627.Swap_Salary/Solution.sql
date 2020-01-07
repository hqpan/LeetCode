UPDATE salary 
SET 
    SEX = CASE sex
        WHEN 'm' THEN 'f'
        ELSE 'm'
    END; 


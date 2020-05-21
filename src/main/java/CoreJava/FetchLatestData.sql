select * from observation where date=(select max(date) from observation)

select * from PetrolTable where price=(select max(date) from PetrolTable)
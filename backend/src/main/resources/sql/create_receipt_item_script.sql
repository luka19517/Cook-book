create table receiptitem(
	id serial primary key,
	name varchar(50) not null,
	quantity bigint not null,
	receipt bigint not null,
	constraint fk_receiptitem_receipt
		foreign key(receipt)
		references receipt(id) 
)
PGDMP     &                	    z           cookbook    15.0    15.0                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            	           1262    16447    cookbook    DATABASE     ?   CREATE DATABASE cookbook WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_United States.1252';
    DROP DATABASE cookbook;
                postgres    false                        3079    16448 	   adminpack 	   EXTENSION     A   CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;
    DROP EXTENSION adminpack;
                   false            
           0    0    EXTENSION adminpack    COMMENT     M   COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';
                        false    2            ?            1259    16458    receipt    TABLE     b   CREATE TABLE public.receipt (
    id integer NOT NULL,
    name character varying(50) NOT NULL
);
    DROP TABLE public.receipt;
       public         heap    postgres    false            ?            1259    16461    receipt_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.receipt_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.receipt_id_seq;
       public          postgres    false    215                       0    0    receipt_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.receipt_id_seq OWNED BY public.receipt.id;
          public          postgres    false    216            ?            1259    16462    receiptitem    TABLE     ?   CREATE TABLE public.receiptitem (
    id integer NOT NULL,
    name character varying(50) NOT NULL,
    quantity bigint NOT NULL,
    receipt bigint NOT NULL
);
    DROP TABLE public.receiptitem;
       public         heap    postgres    false            ?            1259    16465    receiptitem_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.receiptitem_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.receiptitem_id_seq;
       public          postgres    false    217                       0    0    receiptitem_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.receiptitem_id_seq OWNED BY public.receiptitem.id;
          public          postgres    false    218            k           2604    16466 
   receipt id    DEFAULT     h   ALTER TABLE ONLY public.receipt ALTER COLUMN id SET DEFAULT nextval('public.receipt_id_seq'::regclass);
 9   ALTER TABLE public.receipt ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    216    215            l           2604    16467    receiptitem id    DEFAULT     p   ALTER TABLE ONLY public.receiptitem ALTER COLUMN id SET DEFAULT nextval('public.receiptitem_id_seq'::regclass);
 =   ALTER TABLE public.receiptitem ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    218    217                       0    16458    receipt 
   TABLE DATA           +   COPY public.receipt (id, name) FROM stdin;
    public          postgres    false    215                    0    16462    receiptitem 
   TABLE DATA           B   COPY public.receiptitem (id, name, quantity, receipt) FROM stdin;
    public          postgres    false    217   1                  0    0    receipt_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.receipt_id_seq', 1, false);
          public          postgres    false    216                       0    0    receiptitem_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.receiptitem_id_seq', 1, false);
          public          postgres    false    218            n           2606    16469    receipt receipt_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.receipt
    ADD CONSTRAINT receipt_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.receipt DROP CONSTRAINT receipt_pkey;
       public            postgres    false    215            p           2606    16471    receiptitem receiptitem_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.receiptitem
    ADD CONSTRAINT receiptitem_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.receiptitem DROP CONSTRAINT receiptitem_pkey;
       public            postgres    false    217            q           2606    16472 "   receiptitem fk_receiptitem_receipt    FK CONSTRAINT     ?   ALTER TABLE ONLY public.receiptitem
    ADD CONSTRAINT fk_receiptitem_receipt FOREIGN KEY (receipt) REFERENCES public.receipt(id);
 L   ALTER TABLE ONLY public.receiptitem DROP CONSTRAINT fk_receiptitem_receipt;
       public          postgres    false    217    215    3182                   x?????? ? ?            x?????? ? ?     
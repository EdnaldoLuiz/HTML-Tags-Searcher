-- Active: 1690903553751@@containers-us-west-105.railway.app@7537@railway
-- Consulta que busca a quantidade de tags e as tags de acordo com a URL
SELECT tb_tags.tag, tb_tags.quantidade
FROM tb_tags
JOIN tb_urls ON tb_tags.url_info_id = tb_urls.id
WHERE tb_urls.url = 'https://ednaldo-luiz.vercel.app';
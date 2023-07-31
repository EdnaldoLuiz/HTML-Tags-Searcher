-- Active: 1689801237547@@127.0.0.1@3306@nuti

-- Consulta que busca a quantidade de tags e as tags de acordo com a URL
SELECT tb_tags.tag, tb_tags.quantidade
FROM tb_tags
JOIN tb_urls ON tb_tags.url_info_id = tb_urls.id
WHERE tb_urls.url = 'https://ednaldo-luiz.vercel.app';

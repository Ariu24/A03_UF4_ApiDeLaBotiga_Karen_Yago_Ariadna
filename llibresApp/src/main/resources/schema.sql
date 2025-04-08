CREATE TABLE IF NOT EXISTS books (
    id_Llibre BIGINT AUTO_INCREMENT PRIMARY KEY,
    titol VARCHAR(150) UNIQUE NOT NULL,
    autor VARCHAR(150) NOT NULL,
    editorial VARCHAR(150),
    datapublicacio DATE,
    tematica VARCHAR(150),
    isbn VARCHAR (13) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS category (
    id_Categoria BIGINT AUTO_INCREMENT PRIMARY KEY,
    desc_Categoria VARCHAR(255) NOT NULL,
    status_Categoria VARCHAR(50) NOT NULL,
    creation_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);
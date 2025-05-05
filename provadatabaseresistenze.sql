
-- TABELLA ARTICOLI
CREATE TABLE ARTICOLI (
    id INT AUTO_INCREMENT PRIMARY KEY,
    descrizione VARCHAR(255) NOT NULL,
    pezzi_per_locazione INT NOT NULL
);

-- TABELLA LOCAZIONE
CREATE TABLE LOCAZIONE (
    id INT AUTO_INCREMENT PRIMARY KEY,
    magazzino VARCHAR(50),
    corridoio VARCHAR(50),
    colonna VARCHAR(50),
    ripiano VARCHAR(50),
    cella VARCHAR(50)
);

-- TABELLA MOVIMENTI
CREATE TABLE MOVIMENTI (
    id INT AUTO_INCREMENT PRIMARY KEY,
    data_ora_in DATETIME,
    data_ora_out DATETIME,
    id_articolo INT,
    lotto VARCHAR(100),
    id_locazione INT,
    in_entrata INT DEFAULT 0,
    in_uscita INT DEFAULT 0,
    id_riga_ordine VARCHAR(100),
    FOREIGN KEY (id_articolo) REFERENCES ARTICOLI(id),
    FOREIGN KEY (id_locazione) REFERENCES LOCAZIONE(id)
);

-- TABELLA MISSIONI_T
CREATE TABLE MISSIONI_T (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cliente VARCHAR(255),
    data_MT DATE,
    numero VARCHAR(100)
);

-- TABELLA MISSIONI_R
CREATE TABLE MISSIONI_R (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_ordine VARCHAR(100),
    id_articolo INT,
    FOREIGN KEY (id_articolo) REFERENCES ARTICOLI(id)
);

-- TABELLA UTENTI
CREATE TABLE UTENTI (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    cognome VARCHAR(100),
    username VARCHAR(100) UNIQUE,
    password_Utenti VARCHAR(255)
);




# Comprovació dels endpoints del **Swagger**

Aquest document mostra exemples reals de comprovacions dels diferents endpoints implementats per a **Producte**, **Categoria** i **Subcategoria**, així com els missatges d’error que poden aparèixer.

---

## Comprovacions per **Producte**

### Inserir Producte

**Paràmetres d’entrada:**

![Paràmetres d’entrada](image-1.png)

**Resultat esperat:**

![Resultat correcte](image.png)

**Errors possibles:**
- Si la **categoria** o **subcategoria** no existeixen:

![Error per categoria o subcategoria inexistent](image-2.png)

---

### Llistar Productes

![Llistat de productes - exemple 1](image-4.png)  
![Llistat de productes - exemple 2](image-3.png)

---

### Cercar Producte per nom

![Paràmetres de cerca](image-5.png)  
![Resultat trobat](image-6.png)

**En cas que no existeixi cap producte amb aquest nom:**

![Sense resultats](image-7.png)  
![Missatge d’error](image-8.png)

---

### Modificar Preu

![Modificar preu](image-16.png)  
![Resposta de modificació](image-17.png)

**Verificació del canvi:**

- Revisant el producte:
  ![Preu actualitzat](image-18.png)

- A la base de dades, el `updatedAt` ha estat modificat:
  ![updatedAt canviat](image-21.png)

**En cas que el producte no existeixi:**

![Error - producte no trobat](image-19.png)  
![Missatge d’error](image-20.png)

---

### Eliminar Producte

![Eliminar producte](image-25.png)

**Verificació que el producte ha estat eliminat:**

![Producte no apareix](image-26.png)

**En cas que el producte a eliminar no existeixi:**

![Error - producte no existeix](image-24.png)

---

## Comprovacions per **Categoria**

### Inserir Categoria
![Inserir categoria - pas 2](image-10.png)  
![Inserir categoria - resultat](image-11.png)

---

### Llistar Categories

![Llistat categories - 1](image-12.png)  
![Llistat categories - 2](image-13.png)

---

### Cercar Categoria

![Cercar categoria - trobat](image-23.png)

**Si la categoria no existeix:**

![Cercar categoria - no trobat](image-22.png)

---

## Comprovacions per **Subcategoria**

### Inserir Subcategoria

![Inserir subcategoria - entrada](image-27.png)  
![Inserir subcategoria - resultat](image-28.png)

**Si la categoria associada no existeix:**

![Error - categoria inexistent](image-29.png)

---

### Llistar Subcategories

![Llistat de subcategories](image-30.png)

---

### Cercar Subcategoria

![Cercar subcategoria - trobat](image-31.png)  
![Cercar subcategoria - detall](image-32.png)

**Si la subcategoria no existeix:**

![Cercar subcategoria - no trobat](image-33.png)

---

## Endpoints extres ¡

Els tres endpoints addicionals desenvolupats han estat:

- `CercarSubcategoria`
- `CercarCategoria`
- `EliminarProducte`

---

## Possible millora

A última hora ens hem adonat que, per una millor gestió dels missatges d’error, els mètodes del `RestController` haurien de retornar `ResponseEntity`.

---

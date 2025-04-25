Comprovacions dels endpoints del swagger
Comprovacions per Producte:
- InserirProducte
Parametres:
![alt text](image-1.png)
resultat:
![alt text](image.png)
En cas que Categoria o Subcategoria no existeixi o hi hagi algun error es mostra al swagger:
![alt text](image-2.png)
- LlistarProductes
![alt text](image-4.png)
![alt text](image-3.png)
- CercaProducte
![alt text](image-5.png)
![alt text](image-6.png)
En cas que no hi hagi cap producte amb aquest nom retorna:
![alt text](image-7.png)
![alt text](image-8.png)
- ModificarPreu
![alt text](image-16.png)
![alt text](image-17.png)
Ara si anem a revisar el producte:
![alt text](image-18.png)
veiem el preu actualitzat
I a la base de dades el updatedAt canviat
![alt text](image-21.png)
En cas de voler actualitzar un producte que no existeix:
![alt text](image-19.png)
![alt text](image-20.png)
- Eliminar producte
![alt text](image-25.png)
I si el cerquem podem veure que no apareix:
![alt text](image-26.png)
En cas que el producte a eliminar no existeixi:
![alt text](image-24.png)
Comprovacions per Categoria:
- InserirCategoria
![alt text](image-9.png)
![alt text](image-10.png)
![alt text](image-11.png)
- LlistarCategories
![alt text](image-12.png)
![alt text](image-13.png)
- CercaCategoria
![alt text](image-23.png)
En cas que no existeixi:
![alt text](image-22.png)
Comprovacions per SubCategoria:
- InserirSubcategoria
- LlistarSubcategories
- CercarSubcategoria



Els nostres tres endPoints extres han sigut: CercarSubcategoria, CercarCategoria i eliminarProducte
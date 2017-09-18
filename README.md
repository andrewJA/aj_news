# aj_news
This is Spring MVC + Hibernate SCUD project - lent of news.
## Used 
* *IntelliJ IDEA*
* **Maven**
* **Spring MVC**
* **Hibernate**
* **WildFly 10**
* **Bootstrap 4 beta**
* **jQuery**
* in future: +Spring Security, (?Data)




## Script of db:
```sql
DROP TABLE IF EXISTS `Post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Post` (
  `idPost` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `content` text NOT NULL,
  `date` date NOT NULL,
  `category` int(11) NOT NULL,
  PRIMARY KEY (`idPost`),
  KEY `fk_Post_1_idx` (`category`),
  CONSTRAINT `fk_Post_1` FOREIGN KEY (`category`) REFERENCES `Category` (`idCategory`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `Category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Category` (
  `idCategory` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`idCategory`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
```

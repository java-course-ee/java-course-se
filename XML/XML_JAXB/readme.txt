1. Создать набор классов по XSD

xjc BookCatalog.xsd -p edu.gemini.xml.jaxb


2. Создать XSD по набору классов

schemagen edu/gemini/xml/jaxb/*.java

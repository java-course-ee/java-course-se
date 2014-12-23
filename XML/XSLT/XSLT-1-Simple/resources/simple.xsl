<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
        version="2.0"
        xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
        xmlns:b="http://javacourse.ru/xslt/books"
        exclude-result-prefixes="b xalan"
        xmlns:xalan="http://xml.apache.org/xalan"
        >

    <xsl:output method="html" indent="yes" xalan:indent-amount="4"/>

    <xsl:template match="@* | node()"/>

    <xsl:template match="/b:books">
        <html>
            <head>
                <title>Books list</title>
            </head>
            <body>
                <table>
                    <tr>
                        <th>Title</th>
                        <th>Author</th>
                        <th>Publish date</th>
                    </tr>
                    <xsl:apply-templates select="*"/>
                </table>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="b:book">
        <tr>
            <xsl:apply-templates select="*"/>
        </tr>
    </xsl:template>

    <xsl:template match="b:title|b:author|b:publishDate">
        <td><xsl:value-of select="text()"/></td>
    </xsl:template>

</xsl:stylesheet>
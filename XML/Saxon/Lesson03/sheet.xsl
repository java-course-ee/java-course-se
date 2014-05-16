<xsl:stylesheet version = '1.0' 
     xmlns:xsl='http://www.w3.org/1999/XSL/Transform'>

<xsl:template match="bold"> 
     <p> 
          <b> 
               <xsl:value-of select="."/> 
          </b> 
     </p> 
</xsl:template>

<xsl:template match="red"> 
     <p style="color:red"> 
          <xsl:value-of select="."/> 
     </p> 
</xsl:template>

<xsl:template match="italic"> 
     <p> 
          <i> 
               <xsl:value-of select="."/> 
          </i> 
     </p> 
</xsl:template>


</xsl:stylesheet>
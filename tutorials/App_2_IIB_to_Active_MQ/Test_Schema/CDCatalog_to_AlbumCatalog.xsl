<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	version="2.0">
	<xsl:template match="/">
		<Catalog>
			<xsl:for-each select="/CATALOG/CD">
				<Album>
					<Title>
						<xsl:value-of select="TITLE" />
					</Title>
					<Artist>
						<xsl:value-of select="ARTIST" />
					</Artist>
					<Price>
						<xsl:value-of select="PRICE" />
					</Price>
					<Year>
						<xsl:value-of select="YEAR" />
					</Year>
					<Format>Tape</Format>
					<Label>
						<Name>
							<xsl:value-of select="COMPANY" />
						</Name>
						<Country>
							<xsl:value-of select="COUNTRY" />
						</Country>
					</Label>
				</Album>
			</xsl:for-each>
		</Catalog>
	</xsl:template>
</xsl:stylesheet>

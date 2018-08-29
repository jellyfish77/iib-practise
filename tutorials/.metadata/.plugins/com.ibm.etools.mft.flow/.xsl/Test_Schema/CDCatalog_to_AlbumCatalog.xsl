<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<Catalog>
			<xsl:for-each select="/CATALOG/CD">
				<Album>
					<Title>
						<xsl:value-of select="TITLE"></xsl:value-of>
					</Title>
					<Artist>
						<xsl:value-of select="ARTIST"></xsl:value-of>
					</Artist>
					<Price>
						<xsl:value-of select="PRICE"></xsl:value-of>
					</Price>
					<Year>
						<xsl:value-of select="YEAR"></xsl:value-of>
					</Year>
					<Format>Tape</Format>
					<Label>
						<Name>
							<xsl:value-of select="COMPANY"></xsl:value-of>
						</Name>
						<Country>
							<xsl:value-of select="COUNTRY"></xsl:value-of>
						</Country>
					</Label>
				</Album>
			</xsl:for-each>
		</Catalog>
	</xsl:template>
</xsl:stylesheet>
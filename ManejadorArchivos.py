class ManejadorArchivos:

	def  leerArchivo(nombreArchivo):
		archivo = open(nombreArchivo,"r")
		listaResultado=[]
		for linea in archivo.readlines():
			if(linea!=""):
				listaResultado.append(eval(linea))
		archivo.close()
		return listaResultado
		
		
	def escribirArchivo(nombreArchivo,*args):
		archivo= open(nombreArchivo,"a")
		linea="["
		i=0
		for texto in args:
			if(i!=len(args)-1):
				linea+= "'"+texto+"'," 
			else:
				linea+= "'"+texto+"']\n" 
			i+=1
		archivo.write(linea)
		archivo.close()

	def borrarDelArchivo(nombreArchivo,dato):
		f = open(nombreArchivo,"r")
		lineas = f.readlines()
		f.close()
		f = open(nombreArchivo,"w")
		for linea in lineas:
			if(dato not in linea):
				f.write(linea)
		f.close()
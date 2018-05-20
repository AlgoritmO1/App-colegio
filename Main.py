import sys
from Persona import Persona
from Estudiante import Estudiante
from Profesor import Profesor
from Materia import Materia
from Matricula import Matricula
from Mensajes import Mensajes
from ManejadorArchivos import ManejadorArchivos

class Main:
#LISTA DE OBJECTOS DE LAS CLASES	
	listaEstudiantes = []
	listaProfesores = []
	listaMaterias = []
	listaMatriculas = []
#INICIALIZADOR DE LAS OPCIONES DEL MENU	
	def __init__(self):
		self.break_while=1
		self.opcionesEstudiante = {
		"1": self.inscribirEstudiante,
		"2": self.verEstudiante,
		"3": self.editarEstudiante,
		"4": self.borrarEstudiante,
		"5": self.verEstudiantes
		}
		self.opcionesProfesor = {
		"1": self.inscribirProfesor,
		"2": self.verProfesor,
		"3": self.editarProfesor,
		"4": self.borrarProfesor,
		"5": self.verProfesores
		}
		self.opcionesMateria = {
		"1": self.crearMateria,
		"2": self.consultarMateria,
		"3": self.editarMateria,
		"4": self.borrarMateria,
		"5": self.materiaConmasprofesores,
		"6": self.materiaMejorNota,
		"7": self.materiaConmasmatriculas
	    }
		self.opcionesMatricula = {
		"1": self.crearMatricula,
		"2": self.verNota,
		"3": self.asignarNota,
		"4": self.editarNota,
		"5": self.mejorPromedio,
		"6": self.estudiantesPorMateria,
		"7": self.notaMasBaja,
		"8": self.notaMasAlta
		}
		self.otrasOpciones = {
		"1": self.agregarDatos,
		"2": self.salir
		}
#*****************************************MENU PRINCIPAL******************************************************************************************************
	def display_menu(self):
		print("Menu:", "\n 1.", Mensajes.mensajesEstudiante['menu'] , "\n 2." , Mensajes.mensajesProfesor['menu'] ,
		"\n 3." , Mensajes.mensajesMateria['menu'] ,"\n 4." , Mensajes.mensajesMatricula['menu'], "\n 5." , Mensajes.mensajesOtros['menu'])
#************************************MENU PARA OTRAS OPCIONES*****************************************************
	def display_menuOtros(self):
		print(Mensajes.mensajesOtros['menu'] + " :", "\n 1.", Mensajes.mensajesOtros['datosFicticios'] , "\n 2." , Mensajes.mensajesOtros['salir'])


#************************************FUNCIONES PARA LA CLASE MATERIA******************************************************************************************
	def crearMateria(self):
		
		nombre = input(Mensajes.mensajesMateria['ingreseNombre'])
		nuevaMateria = Materia(nombre)
		materiaConsultada = Materia.consultarMateria(Main.listaMaterias, nombre)
		if(not Main.existenciaDato(materiaConsultada)):
			Main.listaMaterias.append(nuevaMateria)
			ManejadorArchivos.escribirArchivo("txtMateria.txt", nombre)
			print(Mensajes.mensajesOtros['operacionExitosa'])
		else:
			print(Mensajes.mensajesOtros['yaExiste'])

	def consultarMateria(self):
		
		nombre = input(Mensajes.mensajesMateria['ingreseNombre'])
		materiaConsultada = Materia.consultarMateria(Main.listaMaterias, nombre)
		if(Main.existenciaDato(materiaConsultada)):
			print(materiaConsultada.toString())
		else:
			print(Mensajes.mensajesOtros['noExiste'])

	def editarMateria(self):
		
		nombre = input(Mensajes.mensajesMateria['ingreseNombre'])
		materiaConsultada = Materia.consultarMateria(Main.listaMaterias, nombre)
		if(Main.existenciaDato(materiaConsultada)):
			cedulaProfesor = input(Mensajes.mensajesProfesor['ingreseCedula'])
			profesorConsultado = Profesor.consultarProfesor(Main.listaProfesores, cedulaProfesor)
			codigoMatricula = input(Mensajes.mensajesMatricula['ingreseCodigo'])
			matriculaConsultada = Matricula.consultarMatricula(Main.listaMatriculas, codigoMatricula)
		else:
			print(Mensajes.mensajesOtros['noExiste'])
			if(Main.existenciaDato(profesorConsultado)):
				if(Main.existenciaDato(matriculaConsultada)):
					materiaConsultada.setProfesor(profesorConsultado)
					materiaConsultada.setMatricula(matriculaConsultada)
					print(Mensajes.mensajesOtros['operacionExitosa'])
				else:
					print(Mensajes.mensajesOtros['noExiste'])
			else:
				print(Mensajes.mensajesOtros['noExiste'])

	def borrarMateria(self):
		
		nombre = input(Mensajes.mensajesMateria['ingreseNombre'])
		materiaConsultada = Materia.consultarMateria(Main.listaMaterias, nombre)
		if(Main.existenciaDato(materiaConsultada)):
			Main.listaMaterias.remove(materiaConsultada)
			materiaConsultada.borrarMateria()
			for profesor in materiaConsultada.getProfesor():
				ManejadorArchivos.borrarDelArchivo("txtProfesor.txt",nombre)
				for matricula in profesor.getMatricula():
					ManejadorArchivos.borrarDelArchivo("txtMatricula.txt",matricula.getCodigo())
				profesor.borrarProfesor()
			ManejadorArchivos.borrarDelArchivo("txtMateria.txt",nombre)
			print(Mensajes.mensajesOtros['operacionExitosa'])
		else:
			print(Mensajes.mensajesOtros['noExiste'])

	def materiaConmasprofesores(self):
		
		print(Materia.materiaConMasProfesores(Main.listaMaterias))

	def materiaMejorNota(self):
		
		print(Materia.materiaMejorNota(Main.listaMaterias))

	def materiaConmasmatriculas(self):

		print(Materia.materiaConmasmatriculas(Main.listaMaterias))

#************************************FUNCIONES PARA LA CLASE MATRICULA****************************************************************************************		
	def crearMatricula(self):
		
		codigo = input(Mensajes.mensajesMatricula['ingreseCodigo'])
		matriculaConsultada = Matricula.consultarMatricula(Main.listaMatriculas, codigo)
		cedulaEstudiante = input(Mensajes.mensajesEstudiante['ingreseCedula'])
		estudianteConsultado = Estudiante.consultarEstudiante(Main.listaEstudiantes, cedulaEstudiante)
		if(not Main.existenciaDato(matriculaConsultada)):
			if(Main.existenciaDato(estudianteConsultado)):
				nombreMateria = input(Mensajes.mensajesMateria['ingreseNombre'])
				materiaConsultada = Materia.consultarMateria(Main.listaMaterias,nombreMateria)
			else:
				print(Mensajes.mensajesOtros['noExiste'])
				if(Main.existenciaDato(materiaConsultada)):
					Profesor.consultarNombreProfesores(materiaConsultada.getProfesor())
					cedulaProfesor = input(Mensajes.mensajesProfesor['ingreseCedula'])
					profesorConsultado = Profesor.consultarProfesor(materiaConsultada.getProfesor(),cedulaProfesor)
				else:
					print(Mensajes.mensajesOtros['noExiste'])
					if(Main.existenciaDato(profesorConsultado)):
						nuevaMatricula = Matricula(codigo , "" ,cedulaEstudiante,cedulaProfesor,nombreMateria,estudianteConsultado, profesorConsultado , materiaConsultada)
						estudianteConsultado.setMatricula(nuevaMatricula)
						materiaConsultada.setMatricula(nuevaMatricula)
						profesorConsultado.setMatricula(nuevaMatricula)
						Main.listaMatriculas.append(nuevaMatricula)
						ManejadorArchivos.escribirArchivo("txtMatricula.txt", codigo , "" ,cedulaEstudiante,cedulaProfesor,nombreMateria)
						print(Mensajes.mensajesOtros['operacionExitosa'])
					else:
						print(Mensajes.mensajesOtros['noExiste'])
		else:
			print(Mensajes.mensajesOtros['yaExiste'])				

	def verNota(self):
		
		codigoMatricula = input(Mensajes.mensajesMatricula['ingreseCodigo'])
		matriculaConsultada = Matricula.consultarMatricula(Main.listaMatriculas, codigoMatricula)
		if(Main.existenciaDato(matriculaConsultada)):
			print("Nota :", matriculaConsultada.getNota())
		else:
			print(Mensajes.mensajesOtros['noExiste'])

	def asignarNota(self):
		
		codigoMatricula = input(Mensajes.mensajesMatricula['ingreseCodigo'])
		matriculaConsultada = Matricula.consultarMatricula(Main.listaMatriculas, codigoMatricula)
		nota = input(Mensajes.mensajesMatricula['ingreseNota'])
		if(float(nota) >= 0 and float(nota) <= 5):
			if(Main.existenciaDato(matriculaConsultada)):
				ManejadorArchivos.borrarDelArchivo("txtMatricula.txt",codigoMatricula)
				ManejadorArchivos.escribirArchivo("txtMatricula.txt", matriculaConsultada.getCodigo() , nota ,matriculaConsultada.getCodEstudiante()
				,matriculaConsultada.getCodProfesor(),matriculaConsultada.getCodMateria())
				matriculaConsultada.setNota(nota)
			else:
				print(Mensajes.mensajesOtros['noExiste'])
		else:
			print(Mensajes.mensajesOtros['notaPermitida'])

	def editarNota(self):
		
		codigoMatricula = input(Mensajes.mensajesMatricula['ingreseCodigo'])
		matriculaConsultada = Matricula.consultarMatricula(Main.listaMatriculas, codigoMatricula)
		nota = input(Mensajes.mensajesMatricula['ingreseNota'])
		if(int(nota) >= 0 and int(nota) <= 5):
			if(Main.existenciaDato(matriculaConsultada)):
				ManejadorArchivos.borrarDelArchivo("txtMatricula.txt",codigoMatricula)
				ManejadorArchivos.escribirArchivo("txtMatricula.txt", matriculaConsultada.getCodigo() , nota ,matriculaConsultada.getCodEstudiante()
				,matriculaConsultada.getCodProfesor(),matriculaConsultada.getCodMateria())
				matriculaConsultada.editarNota(nota)
			else:
				print(Mensajes.mensajesOtros['noExiste'])
		else:
			print(Mensajes.mensajesOtros['notaPermitida'])

	def mejorPromedio(self):
		
		print(Mensajes.mensajesMatricula['mejorPromedioMateria'])
		mejorPromedio = Matricula.mejorPromedio(Main.listaMatriculas,Main.listaMaterias)
		for promedio in mejorPromedio:
			print(promedio)

	def estudiantesPorMateria(self):
		
		Matricula.estudiantesPorMateria(Main.listaMatriculas,Main.listaMaterias)

	def notaMasBaja(self):
		
		print(Mensajes.mensajesMatricula['notaMasBaja'])
		print(Matricula.notaMasBaja(Main.listaMatriculas))

	def notaMasAlta(self):
		
		print(Mensajes.mensajesMatricula['notaMasAlta'])
		print(Matricula.notaMasAlta(Main.listaMatriculas))

#************************************FUNCIONES PARA LA CLASE ESTUDIANTE****************************************************************************************
	def inscribirEstudiante(self):
		
		nombre = input(Mensajes.mensajesEstudiante['ingreseNombre'])
		apellido = input(Mensajes.mensajesEstudiante['ingreseApellido'])
		cedula = input(Mensajes.mensajesEstudiante['ingreseCedula'])
		celular = input(Mensajes.mensajesEstudiante['ingreseCelular']) 
		email = input(Mensajes.mensajesEstudiante['ingreseEmail'])
		estudianteConsultado = Estudiante.consultarEstudiante(Main.listaEstudiantes, cedula)
		if(not Main.existenciaDato(estudianteConsultado)):
			nuevoEstudiante = Estudiante(nombre, apellido, cedula, email, celular)
			Main.listaEstudiantes.append(nuevoEstudiante)
			ManejadorArchivos.escribirArchivo("txtEstudiante.txt", nombre, apellido, cedula, email, celular)
			print(Mensajes.mensajesOtros['operacionExitosa'])
		else:
			print(Mensajes.mensajesOtros['yaExiste'])
		
	def verEstudiante(self):
		
		cedula = input(Mensajes.mensajesEstudiante['ingreseCedula'])
		estudianteConsultado = Estudiante.consultarEstudiante(Main.listaEstudiantes, cedula)
		if(Main.existenciaDato(estudianteConsultado)):
			print(estudianteConsultado.toString())
		else:
			print(Mensajes.mensajesOtros['noExiste'])

	def verEstudiantes(self):
		
		Estudiante.consultarEstudiantes(Main.listaEstudiantes)
   
	def editarEstudiante(self):
		
		cedula = input(Mensajes.mensajesEstudiante['ingreseCedula'])
		estudianteConsultado = Estudiante.consultarEstudiante(Main.listaEstudiantes, cedula)
		if(Main.existenciaDato(estudianteConsultado)):	
			nombre = input(Mensajes.mensajesEstudiante['ingreseNombre'])
			apellido = input(Mensajes.mensajesEstudiante['ingreseApellido'])
			celular = input(Mensajes.mensajesEstudiante['ingreseCelular']) 
			email = input(Mensajes.mensajesEstudiante['ingreseEmail'])
			ManejadorArchivos.borrarDelArchivo("txtEstudiante.txt",cedula)
			ManejadorArchivos.escribirArchivo("txtEstudiante.txt", nombre, apellido, cedula, email, celular)
			estudianteConsultado.editarEstudiante(nombre,apellido,celular,email)
			print(Mensajes.mensajesOtros['operacionExitosa'])
		else:
			print(Mensajes.mensajesOtros['noExiste'])
	
	def borrarEstudiante(self):
		
		cedula = input(Mensajes.mensajesEstudiante['ingreseCedula'])
		estudianteConsultado = Estudiante.consultarEstudiante(Main.listaEstudiantes, cedula)
		if(Main.existenciaDato(estudianteConsultado)):
			Main.listaEstudiantes.remove(estudianteConsultado)
			for matricula in estudianteConsultado.getMatricula():
				Main.listaMatriculas.remove(matricula)
				ManejadorArchivos.borrarDelArchivo("txtMatricula.txt",matricula.getCodigo())
			estudianteConsultado.borrarEstudiante()
			ManejadorArchivos.borrarDelArchivo("txtEstudiante.txt",cedula)
			print(Mensajes.mensajesOtros['operacionExitosa'])
		else:
			print(Mensajes.mensajesOtros['noExiste'])


#************************************FUNCIONES PARA LA CLASE PROFESOR****************************************************************************************
	def inscribirProfesor(self):
		
		nombre = input(Mensajes.mensajesProfesor['ingreseNombre'])
		apellido = input(Mensajes.mensajesProfesor['ingreseApellido'])
		cedula = input(Mensajes.mensajesProfesor['ingreseCedula'])
		telefono = input(Mensajes.mensajesProfesor['ingreseTelefono'])
		oficina = input(Mensajes.mensajesProfesor['ingreseOficina'])
		email = input(Mensajes.mensajesProfesor['ingreseEmail'])
		nombreMateria = input(Mensajes.mensajesMateria['ingreseNombre'])
#Las matriculas del estudiante se instancian en un metodo para matricular una por una
		profesorConsultado = Profesor.consultarProfesor(Main.listaProfesores, cedula) 
		materiaConsultada = Materia.consultarMateria(Main.listaMaterias,nombreMateria)
		if(not Main.existenciaDato(profesorConsultado)):
			if(Main.existenciaDato(materiaConsultada)):
				nuevoProfesor = Profesor(nombre, apellido, cedula, email, telefono, oficina, nombreMateria, materiaConsultada)
				materiaConsultada.setProfesor(nuevoProfesor)
				Main.listaProfesores.append(nuevoProfesor)
				ManejadorArchivos.escribirArchivo("txtProfesor.txt", nombre, apellido, cedula, email, telefono, oficina,nombreMateria)
				print(Mensajes.mensajesOtros['operacionExitosa'])
		else:
			print(Mensajes.mensajesOtros['yaExiste'])

	def verProfesor(self):

		cedula = input(Mensajes.mensajesProfesor['ingreseCedula'])
		profesorConsultado = Profesor.consultarProfesor(Main.listaProfesores, cedula)
		if(Main.existenciaDato(profesorConsultado)):
			print(profesorConsultado.toString())

	def verProfesores(self):
		Profesor.consultarProfesores(Main.listaProfesores)

	def editarProfesor(self):
		cedula = input(Mensajes.mensajesProfesor['ingreseCedula'])
		profesorConsultado = Profesor.consultarProfesor(Main.listaProfesores, cedula)
		if(Main.existenciaDato(profesorConsultado)):
			nombre = input(Mensajes.mensajesProfesor['ingreseNombre'])
			apellido = input(Mensajes.mensajesProfesor['ingreseApellido'])
			email = input(Mensajes.mensajesProfesor['ingreseEmail'])
			telefono = input(Mensajes.mensajesProfesor['ingreseTelefono']) 
			oficina = input(Mensajes.mensajesProfesor['ingreseOficina'])
			ManejadorArchivos.borrarDelArchivo("txtProfesor.txt",cedula)
			ManejadorArchivos.escribirArchivo("txtProfesor.txt", nombre, apellido, cedula, email, telefono, oficina, profesorConsultado.getMateria())
			profesorConsultado.editarProfesor(nombre,apellido,email,telefono,oficina)
			print(Mensajes.mensajesOtros['operacionExitosa'])	
		else:
			print(Mensajes.mensajesOtros['noExiste'])	
    
	def borrarProfesor(self):
		cedula = input(Mensajes.mensajesProfesor['ingreseCedula'])
		profesorConsultado = Profesor.consultarProfesor(Main.listaProfesores, cedula)
		if(Main.existenciaDato(profesorConsultado)):
			Main.listaProfesores.remove(profesorConsultado)
			for matricula in profesorConsultado.getMatricula():
				Main.listaMatriculas.remove(matricula)
				ManejadorArchivos.borrarDelArchivo("txtMatricula.txt",matricula.getCodigo())
			profesorConsultado.borrarProfesor()
			ManejadorArchivos.borrarDelArchivo("txtProfesor.txt",cedula)
			print(Mensajes.mensajesOtros['operacionExitosa'])
		else:
			print(Mensajes.mensajesOtros['noExiste'])

#************************************FUNCIONES DEL SISTEMA*************************************************************************************************
	@staticmethod    
	def existenciaDato(objeto):
		if(objeto != None):
			return True
		else:
			return False

	def salir(self):
		print("Que este bien")
		sys.exit(0)

	@staticmethod
	def agregarDatos():
		
		ListaInstanciasEstudiante=ManejadorArchivos.leerArchivo("txtEstudiante.txt")
		for estudiante in ListaInstanciasEstudiante:
			Main.listaEstudiantes.append(Estudiante(estudiante[0],estudiante[1],estudiante[2],estudiante[3],estudiante[4]))

		ListaInstanciasMateria=ManejadorArchivos.leerArchivo("txtMateria.txt")
		for materia in ListaInstanciasMateria:
			Main.listaMaterias.append(Materia(materia[0]))

		ListaInstanciasProfesor=ManejadorArchivos.leerArchivo("txtProfesor.txt")
		for profesor in ListaInstanciasProfesor:
			materiaProfesor = Materia.consultarMateria(Main.listaMaterias,profesor[6])
			nuevoProfesor = Profesor(profesor[0],profesor[1],profesor[2],profesor[3],profesor[4],profesor[5],profesor[6],materiaProfesor)
			materiaProfesor.setProfesor(nuevoProfesor)
			Main.listaProfesores.append(nuevoProfesor)

		ListaInstanciasMatricula=ManejadorArchivos.leerArchivo("txtMatricula.txt")
		for matricula in ListaInstanciasMatricula:
			materiaMatricula = Materia.consultarMateria(Main.listaMaterias,matricula[4])
			profesorMatricula = Profesor.consultarProfesor(Main.listaProfesores,matricula[3])
			estudianteMatricula = Estudiante.consultarEstudiante(Main.listaEstudiantes,matricula[2])
			nuevaMatricula = Matricula(matricula[0],matricula[1],matricula[2],matricula[3],matricula[4],estudianteMatricula,profesorMatricula,materiaMatricula)
			materiaMatricula.setMatricula(nuevaMatricula)
			profesorMatricula.setMatricula(nuevaMatricula)
			estudianteMatricula.setMatricula(nuevaMatricula)
			Main.listaMatriculas.append(nuevaMatricula)
		print(Mensajes.mensajesOtros['operacionExitosa'])

	def run(self):
		while self.break_while==1:
			self.display_menu()
			print("******************************************")
			opcion=""
			action=""
			print(Mensajes.mensajesOtros['elejirMenu'])
			opcionMenu = int(input())
			if(opcionMenu == 1):
				Estudiante.display_menuEstudiantes()
				print(Mensajes.mensajesOtros['opcion'])
				opcion = input()
				action = self.opcionesEstudiante.get(opcion)
			elif(opcionMenu == 2):
				Profesor.display_menuProfesores()
				print(Mensajes.mensajesOtros['opcion'])
				opcion = input()
				action = self.opcionesProfesor.get(opcion)
			elif(opcionMenu == 4):
				Matricula.display_menuMatriculas()
				print(Mensajes.mensajesOtros['opcion'])
				opcion = input()
				action = self.opcionesMatricula.get(opcion)
			elif(opcionMenu == 3):
				Materia.display_menuMaterias()
				print(Mensajes.mensajesOtros['opcion'])
				opcion = input()
				action = self.opcionesMateria.get(opcion)
			elif(opcionMenu == 5):
				self.display_menuOtros()
				print(Mensajes.mensajesOtros['opcion'])
				opcion = input()
				action = self.otrasOpciones.get(opcion)
			if action:
				action()
			else:
				print(Mensajes.mensajesOtros['opcionNoValida'].format(opcion))		

if __name__ == "__main__":
	Main().run()

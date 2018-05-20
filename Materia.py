from Mensajes import Mensajes
from Matricula import Matricula

class Materia:
  
  def __init__(self, nombre, profesor=None, matricula=None):
    self._nombre = nombre
    self._profesor = []
    self._matricula = []

  def getNombre(self):
    return self._nombre
    
  def setNombre(self, nombre):
    self._nombre = nombre
  
  def getProfesor(self):
      return self._profesor
      
  def setProfesor(self, profesor):
      self._profesor.append(profesor)
      
  def getMatricula(self):
      return self._matricula
  
  def setMatricula(self, matricula):
      self._matricula.append(matricula)
  
  def toString(self):
      return ("Materia : { Nombre: "+ self.getNombre() +
      ", Matriculas: " + Matricula.consultarMatriculas(self.getMatricula()) +"}")
  
  @staticmethod
  def consultarMateria(listaMateria, nombre):
    for materia in listaMateria:
        if materia.getNombre() == nombre:
            return materia
    return None

  @staticmethod
  def consultarMaterias(listaMateria):
    for materia in listaMateria:
        if (materia.getNombre() != None):
            print("\n", materia.toString())

  def editarMateria(self, listaMateria, nombre, profesor, matricula):
      for materia in listaMateria:
          if materia.getNombre() == nombre:
              materia.setNombre(profesor)
              materia.setMatricula(matricula)

  @staticmethod
  def materiaConmasmatriculas(listaMateria):
  	mayor = 0
  	resultadoMateria = ""
  	for materia in listaMateria:
  		if(len(materia.getMatricula())>mayor):
  			mayor = len(materia.getMatricula())
  			resultadoMateria = materia.getNombre()
  	return("La materia con mas matriculas es: " + resultadoMateria + "con " + str(mayor) + " matriculas.")

  @staticmethod
  def materiaConMasProfesores(listaMateria):
    mayor=0
    resultadoMateria=""
    for materia in listaMateria:
      if(len(materia.getProfesor())>mayor):
        mayor=len(materia.getProfesor())
        resultadoMateria = materia.getNombre()
    return("La materia con mas profesores es : "+resultadoMateria+ " con "+ str(mayor) + " profesores.")

  @staticmethod
  def materiaMejorNota(listaMateria):
    mayor=0
    resultado=""
    for materia in listaMateria:
      for matricula in materia.getMatricula():
        if(float(matricula.getNota())>mayor):
          mayor=float(matricula.getNota())
          resultado = matricula
    return("La materia con mayor nota tiene la matricula : "+ resultado.toString())         
  
  def borrarMateria(self):
    self.setNombre(None)

  def display_menuMaterias():
    print (Mensajes.mensajesMateria['menu'] + " :", "\n 1.", Mensajes.mensajesMateria['crear'] , "\n 2.", Mensajes.mensajesMateria['consultar'] , "\n 3." , 
    	Mensajes.mensajesMateria['editar'] , "\n 4." , Mensajes.mensajesMateria['borrar'],"\n 5." , 
    	Mensajes.mensajesMateria['materiaConmasprofesores'],"\n 6." , Mensajes.mensajesMateria['materiaMejorNota'], "\n 7.", 
    	Mensajes.mensajesMateria['materiaConmasmatriculas'])

  

  
from Persona import Persona
from Mensajes import Mensajes
from Matricula import Matricula

class Estudiante(Persona):
  
  def __init__(self, nombre, apellido, cedula, email, celular, matricula=None):
    super().__init__(nombre, apellido, cedula, email)
    self._celular = celular
    self._matricula = []


  def getCelular(self):
    return self._celular
  
  def setCelular(self, celular):
    self._celular = celular
    
  def setMatricula(self, matricula):
  	self._matricula.append(matricula)
  
  def getMatricula(self):
      return self._matricula
  
  @staticmethod
  def consultarEstudiante(listaEstudiante, cedula):
    for estudiante in listaEstudiante:
      if estudiante.getCedula() == cedula:
        return estudiante
    return None

  def toString(self):
    return ("Estudiante : { Nombre: " + super().getNombre() + ", Apellido: " + super().getApellido() + ", Cedula: " + super().getCedula() + ", "
    +", Email: " + super().getEmail() + ", Celular: "+ self.getCelular() + ", Matriculas: " + Matricula.consultarMatriculas(self.getMatricula()) + " }")
   
  @staticmethod
  def consultarEstudiantes(listaEstudiante):
    for estudiante in listaEstudiante:
        print("\n" + estudiante.toString())

  @staticmethod
  def display_menuEstudiantes():
    print(Mensajes.mensajesEstudiante['menu'] + " :", "\n 1.", Mensajes.mensajesEstudiante['inscripcion'] , "\n 2." , 
    	Mensajes.mensajesEstudiante['verEstudiante'] ,"\n 3." , Mensajes.mensajesEstudiante['editar'],"\n 4." , 
    	Mensajes.mensajesEstudiante['borrar'],"\n 5." , Mensajes.mensajesEstudiante['verEstudiantes'])

  def editarEstudiante(self, nombre='', apellido='', celular='', email=''):
    super().setNombre(nombre)
    super().setApellido(apellido)
    super().setEmail(email)
    self.setCelular(celular)

  def borrarEstudiante(self):
    super().setNombre(None)
    super().setApellido(None)
    super().setEmail(None)
    self.setCelular(None)
    Matricula.borrarMatriculas(self.getMatricula())
    super().setCedula(None)
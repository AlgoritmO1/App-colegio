from Persona import Persona
from Mensajes import Mensajes
from Materia import Materia
from Matricula import Matricula

class Profesor(Persona):
  
  def __init__(self, nombre, apellido, cedula, email, telefono, oficina, codMateria, materia, matricula = None):
    super().__init__(nombre, apellido, cedula, email)
    self._telefono = telefono
    self._oficina = oficina
    self._codMateria = codMateria
    self._materia = materia
    self._matricula = []
  
  def getTelefono(self):
    return self._telefono
    
  def setTelefono(self, telefono):
    self._telefono = telefono
    
  def getOficina(self):
    return self._oficina
    
  def setOficina(self, oficina):
    self._oficina = oficina
  
  def setCodMateria(self, codMateria):
    self._codMateria = codMateria

  def getCodMateria(self):
    return self._codMateria

  def setMateria(self, materia):
  	self._materia = materia

  def getMateria(self):
  	return self._materia

  def setMatricula(self, matricula):
  	self._matricula.append(matricula)

  def getMatricula(self):
    return self._matricula

  @staticmethod
  def consultarProfesor(listaProfesor, cedula):
    for profesor in listaProfesor:
      if profesor.getCedula() == cedula:
        return profesor
    return None
  
  @staticmethod
  def consultarProfesores(listaProfesor):
      for profesor in listaProfesor:
          print("\n" + profesor.toString())
          
  @staticmethod
  def consultarNombreProfesores(listaProfesor):
      if listaProfesor==None:
        return ""
      for profesor in listaProfesor:
          if(profesor.getNombre()!=None):
              print("\n" +"Nombre : "+ profesor.getNombre() +", Cedula : "+ profesor.getCedula())

      
  def editarProfesor(self, nombre='', apellido='', email='', telefono='', oficina=''):
    super().setNombre(nombre)
    super().setApellido(apellido)
    super().setEmail(email)
    self.setTelefono(telefono)
    self.setOficina(oficina)
      
  def borrarProfesor(self):
    super().setNombre(None)
    super().setApellido(None)
    super().setCedula(None)
    super().setEmail(None)
    self.setTelefono(None)
    self.setOficina(None)
    Matricula.borrarMatriculas(self.getMatricula())
    
  def toString(self):
      return ("Profesor : { Nombre: " + super().getNombre() +", Apellido: "+ super().getApellido() +", Cedula: " + super().getCedula() + ", Email: "
      +", "+ super().getEmail() +", Telefono: "+ self.getTelefono() + ", Oficina: " + self.getOficina() + ", Materia: " + self.getCodMateria() +
       ", Matriculas: " + Matricula.consultarMatriculas(self.getMatricula()) + "}")

  def display_menuProfesores():
    print (Mensajes.mensajesProfesor['menu'] + " :", "\n 1.", Mensajes.mensajesProfesor['inscripcion'] , "\n 2." , Mensajes.mensajesProfesor['verProfesor'] ,
    "\n 3." , Mensajes.mensajesProfesor['editar'],"\n 4." , Mensajes.mensajesProfesor['borrar'],"\n 5." , Mensajes.mensajesProfesor['verProfesores'])
    

  

  
  
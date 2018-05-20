class Persona:
  
  def __init__(self, nombre, apellido, cedula, email):
    self._nombre = nombre
    self._apellido = apellido
    self._cedula = cedula
    self._email = email
  
  def getNombre(self):
    return self._nombre
    
  def setNombre(self, nombre):
    self._nombre = nombre
    
  def getApellido(self):
    return self._apellido
  
  def setApellido(self, apellido):
    self._apellido = apellido
    
  def getCedula(self):
    return self._cedula
  
  def setCedula(self, cedula):
    self._cedula = cedula
  
  def getEmail(self):
    return self._email
    
  def setEmail(self, email):
    self._email = email
    
    
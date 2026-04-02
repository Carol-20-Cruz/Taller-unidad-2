const express = require('express');
const app = express();
app.use(express.json());

const servicios = [
  { id: 1, nombre: "Asesoría Académica", descripcion: "Orientación sobre tu proceso académico", cupos: 15, horario: "7am - 12pm" },
  { id: 2, nombre: "Certificados", descripcion: "Solicitud de documentos oficiales", cupos: 20, horario: "8am - 5pm" },
  { id: 3, nombre: "Bienestar Universitario", descripcion: "Apoyo psicológico y social", cupos: 10, horario: "7am - 3pm" },
  { id: 4, nombre: "Secretaría Académica", descripcion: "Trámites administrativos", cupos: 18, horario: "8am - 4pm" },
  { id: 5, nombre: "Pagos y Financiera", descripcion: "Pagos de matrícula y otros", cupos: 25, horario: "8am - 5pm" },
  { id: 6, nombre: "Biblioteca", descripcion: "Préstamo de libros y recursos", cupos: 30, horario: "7am - 6pm" }
];

const turnos = [];

app.get('/api/servicios', (req, res) => {
  res.json(servicios);
});

app.get('/api/servicios/:id', (req, res) => {
  const servicio = servicios.find(s => s.id === parseInt(req.params.id));
  if (!servicio) return res.status(404).json({ error: "Servicio no encontrado" });
  res.json(servicio);
});

app.post('/api/turnos', (req, res) => {
  const { nombre, documento, servicioId } = req.body;
  if (!nombre || !documento || !servicioId) {
    return res.status(400).json({ error: "Faltan campos requeridos" });
  }
  const servicio = servicios.find(s => s.id === parseInt(servicioId));
  if (!servicio) return res.status(404).json({ error: "Servicio no existe" });
  const turno = { id: turnos.length + 1, nombre, documento, servicio: servicio.nombre, hora: new Date().toLocaleTimeString() };
  turnos.push(turno);
  res.status(201).json({ mensaje: "Turno creado exitosamente", turno });
});

app.listen(3000, () => console.log('Servidor corriendo en http://localhost:3000'));
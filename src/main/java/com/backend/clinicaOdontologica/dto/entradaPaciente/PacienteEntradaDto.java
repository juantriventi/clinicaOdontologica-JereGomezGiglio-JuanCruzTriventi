package com.backend.clinicaOdontologica.dto.entradaPaciente;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

    public class PacienteEntradaDto {

        @NotNull(message = "El nombre del paciente no puede ser nulo")
        @NotBlank(message = "Debe especificarse el nombre del paciente")
        @Size(max = 50, message = "El nombre debe tener hasta 50 caracteres")
        private String nombre;

        @Size(max = 50, message = "El apellido debe tener hasta 50 caracteres")
        @NotNull(message = "El apellido del paciente no puede ser nulo")
        @NotBlank(message = "Debe especificarse el apellido del paciente")
        private String apellido;

        @NotNull(message = "El dni del paciente no puede ser nulo")
        @Max(value = 99999999, message = "El DNI no puede tener más de 8 dígitos")
        private Integer dni;

        @FutureOrPresent(message = "La fecha no puede ser anterior al día de hoy")
        @NotNull(message = "Debe especificarse la fecha de ingreso del paciente")
        //@JsonProperty("fecha_ingreso")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        private LocalDate fechaIngreso;

        @NotNull(message = "El domicilio del paciente no puede ser nulo")
        @Valid
        private DomicilioEntradaDto domicilioEntradaDto;


        public PacienteEntradaDto() {
        }

        public PacienteEntradaDto(String nombre, String apellido, Integer dni, LocalDate fechaIngreso, DomicilioEntradaDto domicilioEntradaDto) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.dni = dni;
            this.fechaIngreso = fechaIngreso;
            this.domicilioEntradaDto = domicilioEntradaDto;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public Integer getDni() {
            return dni;
        }

        public void setDni(Integer dni) {
            this.dni = dni;
        }

        public LocalDate getFechaIngreso() {
            return fechaIngreso;
        }

        public void setFechaIngreso(LocalDate fechaIngreso) {
            this.fechaIngreso = fechaIngreso;
        }

        public DomicilioEntradaDto getDomicilioEntradaDto() {
            return domicilioEntradaDto;
        }

        public void setDomicilioEntradaDto(DomicilioEntradaDto domicilioEntradaDto) {
            this.domicilioEntradaDto = domicilioEntradaDto;
        }
}

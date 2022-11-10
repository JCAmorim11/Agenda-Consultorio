package br.com.medicalClinic.agenda.enums;

public enum AppointmentStatus {
  PENDENTE("Pendente"),
  CONCLUIDO("Concluido"),
  CANCELADO("Cancelado");

  private String status;

  AppointmentStatus(String status) {
    this.status = status;
  }

  public String getStatus() {
    return status;
  }

}

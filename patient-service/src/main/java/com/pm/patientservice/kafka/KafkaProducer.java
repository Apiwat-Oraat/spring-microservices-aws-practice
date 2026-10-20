package com.pm.patientservice.kafka;

import com.pm.patientservice.model.Patient;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import patient.events.PatientEvent;

@Service
public class KafkaProducer {

    private static final Logger log = LoggerFactory.getLogger(KafkaProducer.class);
    private final KafkaTemplate<String, byte[]> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, byte[]> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

//    public void sendEvent(Patient patient) {
//        PatientEvent event = PatientEvent.newBuilder()
//                .setPatientId(patient.getId().toString())
//                .setName(patient.getName())
//                .setEmail(patient.getEmail())
//                .setEventType("PATIENT_CREATED")
//                .build();
//        try {
//            kafkaTemplate.send("patient", event.toByteArray());
//        } catch (Exception e) {
//            log.error("Error sending PatientCreated event: {}", event);
//        }
//    }

    public void sendEvent(Patient patient) {
        PatientEvent event = PatientEvent.newBuilder()
                .setPatientId(patient.getId().toString())
                .setName(patient.getName())
                .setEmail(patient.getEmail())
                .setEventType("PATIENT_CREATED")
                .build();

        kafkaTemplate.send("patient", event.toByteArray())
                .whenComplete((result, ex) -> {
                    if (ex != null) {
                        log.error("Failed to send PatientEvent", ex);
                    } else {
                        log.info(
                                "Successfully sent to topic={}, partition={}, offset={}",
                                result.getRecordMetadata().topic(),
                                result.getRecordMetadata().partition(),
                                result.getRecordMetadata().offset()
                        );
                    }
                });
    }

}

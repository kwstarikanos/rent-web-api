package gr.uoa.di.rent.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import gr.uoa.di.rent.models.audit.UserDateAudit;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "calendars", schema = "rent")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "start_date",
        "end_date",
        "room_id"
})
public class Calendar extends UserDateAudit implements Serializable {

    @Id
    @Column(name = "id")
    @JsonProperty("id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_date", nullable = false)
    @JsonProperty("start_date")
    private LocalDate start_date;

    @Column(name = "end_date")
    @JsonProperty("end_date")
    private LocalDate end_date;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "room", nullable = false)
    @JsonIgnore
    private Room room;

    @Transient
    @JsonProperty("room_id")
    private Long room_id;

    @OneToOne(mappedBy = "calendar", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Reservation reservation;


    public Calendar() {
    }

    public Calendar(LocalDate start_date, LocalDate end_date, Room room) {
        this.start_date = start_date;
        this.end_date = end_date;
        this.setRoom(room);
    }

    public Calendar(LocalDate start_date, LocalDate end_date, Reservation reservation, Room room) {
        this.start_date = start_date;
        this.end_date = end_date;
        this.reservation = reservation;
        this.setRoom(room);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
        this.setRoom_id(room.getId());
    }

    public Long getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Long room_id) {
        this.room_id = room_id;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    @Override
    public String toString() {
        return "Calendar{" +
                "id=" + id +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", room_id=" + room_id +
                '}';
    }
}

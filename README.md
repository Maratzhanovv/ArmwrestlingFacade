Armwrestling Tournament — Facade Pattern

This Java project prepares the first round of an armwrestling tournament.
It registers participants, groups them by weight, creates random pairings,
and prepares a match schedule.

Pattern roles

Client: Main
Facade: TournamentFacade
Subsystem: RegistrationService, WeightCategoryService,
PairingService, ScheduleService
Data model: Participant

Main uses only TournamentFacade.
The facade coordinates the four services in the correct order.
The services do not reference the facade and can be used independently.

Clean Code principles

1. Meaningful names
   Names such as registerParticipant and createSchedule explain their purpose.

2. Single Responsibility
   Each service has one responsibility. The facade only coordinates the services.

3. Encapsulation
   Participant fields are private and final.
   RegistrationService returns a copy of its participant list.

4. Small public interface
   The facade exposes only registerParticipant and startTournament.
   The client does not need to know about the subsystem classes.

5. Error handling
   The program rejects invalid weights, empty names, duplicate registrations,
   and attempts to start a tournament with fewer than two participants.
   Registration closes after the tournament starts.

6. Small focused methods
   Validation, weight grouping, pairing, and scheduling are separate operations.

How to run

Use JDK 17 or newer.
Open the project in IntelliJ IDEA and run Main.java.

Project rules

Weight categories are up to 70 kg, up to 90 kg, and over 90 kg.
Matches start at 10:00 and take 10 minutes each.
An unpaired participant advances automatically.
This project prepares only the first round.
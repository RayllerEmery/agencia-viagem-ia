package me.rayll;

import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@ApplicationScoped
public class BookingService {

    private final Map<Long, Booking> bookings = new HashMap<>();

    public BookingService() {
        bookings.put(
                12345L,
                new Booking(1L, "Bob Johnson", "Tesouros do Egito",
                        LocalDate.now().plusMonths(1),
                        LocalDate.now().plusMonths(1).plusDays(7),
                        BookingStatus.CONFIRMED, Category.TREASURES));

        bookings.put(67890L,
                new Booking(2L, "Alice Smith", "Aventura Amazônica",
                        LocalDate.now().plusMonths(2),
                        LocalDate.now().plusMonths(2).plusDays(10),
                        BookingStatus.CONFIRMED, Category.ADVENTURE));
        bookings.put(98765L,
                new Booking(3L, "Peter Jones", "Trilha Inca",
                        LocalDate.now().plusMonths(3),
                        LocalDate.now().plusMonths(3).plusDays(10),
                        BookingStatus.CONFIRMED, Category.ADVENTURE));
    }

    public Optional<Booking> getBookingById(Long id) {
        return Optional.ofNullable(bookings.get(id));
    }

    public List<Booking> findByCategory(Category category) {
        return bookings.values().stream()
                .filter(b -> category.equals(b.category()))
                .toList();
    }

    public Optional<Booking> cancelBooking(Long id, String name) {
        if (bookings.containsKey(id)) {
            var booking = bookings.get(id);
            if (booking.customerName().equals(name)) {
                var canceledBook =
                        new Booking(booking.id(), booking.customerName(), booking.destination(),
                                booking.startDate(), booking.endDate(), BookingStatus.CANCELLED, booking.category());
                bookings.put(id, canceledBook);
                return Optional.of(canceledBook);
            }
        }
        return Optional.empty();
    }
}

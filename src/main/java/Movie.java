import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Movie {

    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String title;

    @SerializedName("length")
    private int lenght;

    @SerializedName("category")
    private String[] category;

    @SerializedName("view")
    private int view;

    @SerializedName("year")
    private int year;

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", lenght=" + lenght +
                ", category=" + Arrays.toString(category) +
                ", view=" + view +
                ", year=" + year +
                '}';
    }
}
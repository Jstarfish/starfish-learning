package pipeline.stage;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class StoppablePipeline<I, O> {
    @Getter
    private final List<Stage<I, O>> stages;

    public StoppablePipeline() {
        this.stages = new ArrayList<>();
    }

    public StoppablePipeline(Stage<I,O> stage){
        this();
        addStage(stage);
    }

    public StoppablePipeline<I, O> addStage(Stage<I,O> stage){
        stages.add(stage);
        return this;
    }

    public void execute(I input){
        assert stages.size() > 0;
        int i = 0;
        while (i < stages.size() && stages.get(i).process(input) !=null){
            i++;
        }
    }


    public interface Stage<I, O> {
        O process(I input);
    }
}
